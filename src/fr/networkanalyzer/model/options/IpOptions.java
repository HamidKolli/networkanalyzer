package fr.networkanalyzer.model.options;

import fr.networkanalyzer.model.exceptions.NetworkAnalyzerException;
import fr.networkanalyzer.model.fields.Entry;

public enum IpOptions {

	EOOL(new Entry<>("End of Options List", 0)), NOP(new Entry<>("No Operation", 1)),
	RR(new Entry<>("Record Route", 7)), TS(new Entry<>("Time Stamp", 68)), LSR(new Entry<>("Loose Source Route", 131)),
	SSR(new Entry<>("Strict Source Route", 137));

	private Entry<String, Integer> option;

	IpOptions(Entry<String, Integer> entry) {
		this.option = entry;
	}

	public static Entry<String, Integer> getEntryByCode(int code) throws NetworkAnalyzerException {
		IpOptions[] options = values();
		for (int j = 0; j < options.length; j++)
			if (code == options[j].option.getValue())
				return options[j].option;

		throw new NetworkAnalyzerException("Unexpected value of the option");
	}
}
