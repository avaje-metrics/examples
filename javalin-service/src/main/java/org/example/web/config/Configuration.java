package org.example.web.config;

import io.dinject.Bean;
import io.dinject.Factory;
import io.avaje.metrics.MetricManager;
import io.avaje.metrics.report.MetricReportConfig;
import io.avaje.metrics.report.MetricReportManager;

@Factory
class Configuration {

  @Bean
  MetricReportManager metrics() {

    MetricManager.jvmMetrics()
      .registerStandardJvmMetrics()
      .registerCGroupMetrics()
      .registerLogbackMetrics();

    MetricReportConfig config = new MetricReportConfig();
    config.setDirectory("/tmp/metrics");
    config.setMetricsFileName("metrics-ex1");

    // report aggregate statistics every 10 seconds to local csv file
    config.setFreqInSeconds(10);

    return new MetricReportManager(config);
  }
}
