package com.model.bookstore;

public class CartItem {

    private Books book;// ͼ�����ĳ�Ա����
    private Integer number;// �����������

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
