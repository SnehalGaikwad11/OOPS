package objectorientedprograms.Commercial;

public class Company 
	{
		private String stockName;
		private String stockSymbol;
		private String noOFShare;
		private String sharePrice;
		public Company(){}
		public Company(String stockName, String stockSymbol, String noOFShare, String sharePrice) {
			super();
			this.stockName = stockName;
			this.stockSymbol = stockSymbol;
			this.noOFShare = noOFShare;
			this.sharePrice = sharePrice;
		}

		public String getStockName() {
			return stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}

		public String getStockSymbol() {
			return stockSymbol;
		}

		public void setStockSymbol(String stockSymbol) {
			this.stockSymbol = stockSymbol;
		}

		public String getNoOFShare() {
			return noOFShare;
		}

		public void setNoOFShare(String noOFShare) {
			this.noOFShare = noOFShare;
		}

		public String getSharePrice() {
			return sharePrice;
		}

		public void setSharePrice(String sharePrice) {
			this.sharePrice = sharePrice;
		}	
	}
