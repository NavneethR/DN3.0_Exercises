package com.example.bookstoreapi.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMetricsService {

    private final MeterRegistry meterRegistry;

    @Autowired
    public CustomMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initializeMetrics();
    }

    private void initializeMetrics() {
        meterRegistry.gauge("custom_metric_total", this, CustomMetricsService::getCustomMetricValue);
    }

    public double getCustomMetricValue() {
        // Return some custom metric value; this is just an example
        return Math.random() * 100;
    }
}
