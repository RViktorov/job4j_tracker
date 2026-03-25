package ru.job4j.ood.lsp.example;

public class CancelledOrder extends Order {
    @Override
    public String getStatus() {
        return null; // ослабление постусловий-нарушение LSP
    }

}