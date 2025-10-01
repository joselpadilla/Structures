package com.challenges.streams;

import java.math.BigDecimal;
import java.util.List;

public record Book(int id, String title, double value, List<BigDecimal> sells) {}
