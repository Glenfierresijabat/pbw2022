/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplikasimahasiswabaru;

/**
 *
 * @author LENOVO
 */
public class datasiswa {

    /**
     * @return the nodaftar
     */
    public String getNodaftar() {
        return nodaftar;
    }

    /**
     * @param nodaftar the nodaftar to set
     */
    public void setNodaftar(String nodaftar) {
        this.nodaftar = nodaftar;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jurusan
     */
    public jurusan getJurusan() {
        return jurusan;
    }

    /**
     * @param jurusan the jurusan to set
     */
    public void setJurusan(jurusan jurusan) {
        this.jurusan = jurusan;
    }
    private String nodaftar;
    private String nama;
    private jurusan jurusan;
    public datasiswa () {}
    public datasiswa (String nodaftar, String nama, jurusan jurusan ){
        this.nodaftar = nodaftar;
        this.nama = nama;
        this.jurusan = jurusan;
        
    }
}
