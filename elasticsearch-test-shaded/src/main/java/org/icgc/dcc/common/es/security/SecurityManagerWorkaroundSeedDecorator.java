package org.icgc.dcc.common.es.security;

import com.carrotsearch.randomizedtesting.SeedDecorator;

/**
 * Very ugly workaround to disable the SecurityManager that Elasticsearch now injects in Tests, it is cumbersome to set
 * up the security policy everywhere and causes lots of test-failures and strange side-effects, e.g.
 * https://issues.gradle.org/browse/GRADLE-2170, which hangs junit test runs in Gradle as a result
 * 
 * @see https://github.com/Dynatrace/Dynatrace-Elasticsearch-Plugin/blob/master/testsrcES5/org/elasticsearch/test/SecurityManagerWorkaroundSeedDecorator.java
 */
public class SecurityManagerWorkaroundSeedDecorator implements SeedDecorator {

  @Override
  public void initialize(Class<?> suiteClass) {
    System.setProperty("tests.security.manager", "false");
  }

  @Override
  public long decorate(long seed) {
    return seed;
  }

}
