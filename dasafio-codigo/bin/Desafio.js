//Lê os valores de Entrada:
const valorSalario = parseFloat(gets());
const valorBeneficios = parseFloat(gets());

//Calcula o imposto atráves da função "calcularImposto":
const valorImposto = calcularImposto(valorSalario);
//Calcula e imprime a Saída (com 2 casas decimais):
const saida = valorSalario - valorImposto + valorBeneficios;
print(saida.toFixed(2));

//Função útil para o calculo do imposto (beasado nas aliquotas).
function calcularImposto(salario) {
    let aliquota;
    if(salario >= 0 && salario <= 1100){
        aliquota = 0.05;
    }else if(salario >= 0 && salario <= 2500){
        aliquota = 0.10;
    }else{
        aliquota = 0.15;
    }
    return aliquota * salario;
}