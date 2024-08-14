package me.velfinvelasquez.problema;


import me.velfinvelasquez.models.Document;

interface Printer {
    void print(Document document);
    void scan(Document document);
    void fax(Document document);
}