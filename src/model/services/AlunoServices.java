package model.services;

import java.time.LocalDate;
import java.time.Period;
import model.entity.Aluno;

public class AlunoServices {
	public static boolean isRestrito(Aluno aluno) {
		boolean restr = true;
		if (aluno.getPeriodoRestrito() != 0) {
            LocalDate hoje = LocalDate.now();
            Period periodo = Period.between(LocalDate.parse(aluno.getDataRestricao()), hoje);
            int difData, ano, mes, dia;
            ano = periodo.getYears();
            mes = periodo.getMonths();
            dia = periodo.getDays();
            difData= (ano * 365) + (mes *30) + dia;
            if (aluno.getPeriodoRestrito() - difData <= 0) {
            	restr = false;
            }
        }
		return restr;
	}
}