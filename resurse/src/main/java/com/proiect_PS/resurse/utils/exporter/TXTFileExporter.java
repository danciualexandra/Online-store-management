package com.proiect_PS.resurse.utils.exporter;

public class TXTFileExporter implements FileExporter{
    @Override
    public String exportData(Object object) {
        return object.toString();
    }
}
