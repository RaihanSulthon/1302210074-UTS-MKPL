package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	public static final int SINGLE_NON_TAXABLE = 54000000;
	public static final int MARRIED_NON_TAXABLE = SINGLE_NON_TAXABLE + 4500000;
	public static final int PER_CHILD_NON_TAXABLE = 1500000;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int tax = 0;
	
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	
		int nonTaxableIncome = SINGLE_NON_TAXABLE;
		if (isMarried) {
			nonTaxableIncome = MARRIED_NON_TAXABLE;
		}
	
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
	
		tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (nonTaxableIncome + (numberOfChildren * PER_CHILD_NON_TAXABLE))));
	
		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}
	}
}