package com.example.newest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;

public class BarChartView extends View {
    private Map<String, Map<String, Integer>> weeklyData;
    private String metric;
    private String chartTitle;
    private Paint barPaint;
    private Paint textPaint;
    private Paint titlePaint;

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        barPaint = new Paint();
        barPaint.setColor(Color.BLUE);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);

        titlePaint = new Paint();
        titlePaint.setColor(Color.BLACK);
        titlePaint.setTextSize(48);
        titlePaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setData(Map<String, Map<String, Integer>> weeklyData, String metric, String chartTitle) {
        this.weeklyData = weeklyData;
        this.metric = metric;
//        this.chartTitle = chartTitle;
        invalidate(); // Redraw the chart with the new data
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (weeklyData == null || metric == null) return;

        float width = getWidth();
        float height = getHeight();
        float barWidth = width / (weeklyData.size() * 2 + 1); // Dynamic bar width to allow spacing
        float spaceWidth = barWidth; // Equal spacing between bars
        float totalContentHeight = height - 200; // Reserve space for title and padding
        float padding = 60;

        // Find max value for scaling
        int maxValue = 0;
        for (Map<String, Integer> data : weeklyData.values()) {
            maxValue = Math.max(maxValue, data.getOrDefault(metric, 0));
        }

        // Calculate vertical centering offset
        float chartHeight = totalContentHeight - padding * 2;
        float centerOffset = (height - chartHeight) / 2;

        // Draw the chart title
        if (chartTitle != null) {
            canvas.drawText(chartTitle, width / 2, centerOffset - 20, titlePaint); // Title at the top center
        }

        int index = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : weeklyData.entrySet()) {
            String day = entry.getKey();
            int value = entry.getValue().getOrDefault(metric, 0);

            float x = spaceWidth + barWidth / 2 + index * (barWidth + spaceWidth);
            float barHeight = (value / (float) maxValue) * chartHeight;

            // Draw bar
            canvas.drawRect(
                    x - barWidth / 2,
                    height - barHeight - centerOffset - padding,
                    x + barWidth / 2,
                    height - centerOffset - padding,
                    barPaint
            );

            // Draw day label
            canvas.drawText(day, x - barWidth / 4, height - centerOffset - padding + 40, textPaint);

            // Draw value label
            canvas.drawText(
                    String.valueOf(value),
                    x - barWidth / 4,
                    height - barHeight - centerOffset - padding - 10,
                    textPaint
            );

            index++;
        }
    }
}
