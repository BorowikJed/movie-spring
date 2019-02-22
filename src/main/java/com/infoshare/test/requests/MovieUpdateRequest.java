package com.infoshare.test.requests;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class MovieUpdateRequest {
    @Min(3)
    @NotEmpty
    private final String title;
    @Min(1900)
    private final int year;

    public MovieUpdateRequest(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
