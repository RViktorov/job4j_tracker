package ru.job4j.ood.lsp.example;

public class DownloadLogger extends Logger {
    @Override
    public void log(String message) {
        // метод не реализован в наследнике, идет ослабление постусловий-нарушение LSP
    }

}