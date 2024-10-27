package kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
public class IngressoVip extends Ingresso {
    private String funcao;

    public IngressoVip(String codIdentificador, float valor, String funcao) {
        super(codIdentificador, valor);
        this.funcao = funcao;
    }

    public String getFuncao (){
        return funcao;
    }

    public void setFuncao (String auxfuncao){
        this.funcao = auxfuncao;
    }

    public float valorfinal(float valorTaxa){
        float valor = super.getValor();
        return valor * 1.18f + valorTaxa;
    }
}
