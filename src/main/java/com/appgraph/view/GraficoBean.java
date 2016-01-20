package com.appgraph.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.appgraph.model.Grafico;
import com.appgraph.service.GestaoGrafico;
import com.appgraph.service.impl.GestaoGraficoImpl;
import com.google.inject.Inject;

@SuppressWarnings("serial")
@ManagedBean
public class GraficoBean implements Serializable {

	//@Inject
	GestaoGrafico gg = new GestaoGraficoImpl();

	private BarChartModel barModel;
	private int max_eixo_y = 0;

	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		Grafico grafico = new Grafico();
		List<Grafico> linhasGrafico = gg.porNome(grafico);
		ChartSeries serie = new ChartSeries();
		serie.setLabel(linhasGrafico.get(1).getNome_grafico());
		for (Grafico lGrafico : linhasGrafico) {
			serie.set(lGrafico.getSerie().toString(), Integer.parseInt(lGrafico.getEixo_y()));
			if (max_eixo_y < Integer.parseInt(lGrafico.getEixo_y())) {
				setMax_eixo_y(Integer.parseInt(lGrafico.getEixo_y()));
			}
		}

		model.addSeries(serie);

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Tempo processamento");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Tempo");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade");
		yAxis.setMin(0);
		yAxis.setMax(getMax_eixo_y() + (getMax_eixo_y() * 20) / 100);
	}

	public int getMax_eixo_y() {
		return max_eixo_y;
	}

	public void setMax_eixo_y(int max_eixo_y) {
		this.max_eixo_y = max_eixo_y;
	}
}