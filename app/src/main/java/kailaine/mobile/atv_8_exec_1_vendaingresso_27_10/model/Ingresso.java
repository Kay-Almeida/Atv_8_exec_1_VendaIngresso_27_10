package kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model;

public class Ingresso {
    private String codIdentificador;
    private float valor;

    public Ingresso(String codIdentificador, float valor) {
        this.codIdentificador = codIdentificador;
        this.valor = valor;
    }
    public float valorfinal(float valorTaxa){
        return valor+valorTaxa;
    }

    public float getValor(){
        return valor;
    }
    public void setValor(float preco){
        this.valor = preco;
    }
    public String getCodIdentificador(){
        return codIdentificador;
    }
    public void setCodIdentificador(String cod){
        this.codIdentificador = cod;
    }
}
