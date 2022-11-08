package com.github.plokhotnyuk.jsoniter_scala.benchmark

import java.nio.charset.StandardCharsets.UTF_8

class MapOfIntsToBooleansReadingSpec extends BenchmarkSpecBase {
  def benchmark: MapOfIntsToBooleansReading = new MapOfIntsToBooleansReading {
    setup()
  }

  "MapOfIntsToBooleansReading" should {
    "read properly" in {
      benchmark.jsoniterScala() shouldBe benchmark.obj
      benchmark.smithy4sJson() shouldBe benchmark.obj
    }
    "fail on invalid input" in {
      val b = benchmark
      b.jsonBytes = "[]".getBytes(UTF_8)
      intercept[Throwable](b.jsoniterScala())
      intercept[Throwable](b.smithy4sJson())
    }
  }
}