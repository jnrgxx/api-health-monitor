package com.nemo.api_health_monitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Catch-all for any unhandled RuntimeException (500 Internal Server Error).
     * This is a safety net — you should handle specific exceptions where possible.
     */
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleGenericError(RuntimeException ex) {
        return createProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
    }

    /**
     * Helper method to create a consistent ProblemDetail response.
     * ProblemDetail gives us a standardized JSON structure:
     * {
     *   "type": "about:blank",
     *   "title": "Not Found",
     *   "status": 404,
     *   "detail": "Bucket not found with id: ...",
     *   "instance": "/api/v1/buckets/..."
     *   "timestamp": "2026-06-10T23:53:00"
     * }
     */
    private ProblemDetail createProblemDetail(HttpStatus status, String message) {
        var detail = ProblemDetail.forStatusAndDetail(status, message);
        detail.setTitle(status.getReasonPhrase());
        detail.setProperty("timestamp", LocalDateTime.now().toString());
        return detail;
    }
}
