
public class CalculateDistanceBetweentoCoordinate {

	public static void main(String[] args) {
		CalculateDistanceBetweentoCoordinate betweentoCoordinate = new CalculateDistanceBetweentoCoordinate();
		System.out.println(betweentoCoordinate.ditanceBetweenCoordinate(31.9697, -96.80322, 21.46786, -98.53506, "M") + " Miles\n");
		System.out.println(betweentoCoordinate.ditanceBetweenCoordinate(29.9697, -96.80322, 22.46786, -98.53506, "K") + " Kilometers\n");
		System.out.println(betweentoCoordinate.ditanceBetweenCoordinate(30.9697, -96.80322, 23.46786, -98.53506, "N") + " Nautical Miles\n");
	}

	private  double ditanceBetweenCoordinate(double startPointlongitude, double startPointlatitude,
			double endPointlongitude, double endPointlatitude, String unit) {
		try {
			if ((endPointlongitude == startPointlongitude) && (endPointlatitude == startPointlatitude)) {
				return 0.0;
			}
			else {
				double theta = endPointlongitude - startPointlongitude;

				double distanceBetweenPoint = Math.sin(Math.toRadians(endPointlongitude)) * Math.sin(Math.toRadians(endPointlatitude)) + Math.cos(Math.toRadians(startPointlatitude)) * Math.cos(Math.toRadians(endPointlatitude)) * Math.cos(Math.toRadians(theta));
				distanceBetweenPoint = Math.acos(distanceBetweenPoint);
				distanceBetweenPoint = Math.toDegrees(distanceBetweenPoint);
				distanceBetweenPoint = distanceBetweenPoint * 60 * 1.1515;
				distanceBetweenPoint = distanceBetweenPoint * 1.609344;

				if (unit == "K") {
					distanceBetweenPoint = distanceBetweenPoint * 1.609344;
				} else if (unit == "N") {
					distanceBetweenPoint = distanceBetweenPoint * 0.8684;
				}
				return distanceBetweenPoint;
			}

		} catch (Exception e) { 
			System.out.println("Please check error "+ e.getMessage());
			return 0.0;
		}
	}

}
