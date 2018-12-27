package winter18.assignment3;


public class Path {
	
	int[][] aPath;
	static int count = 0;

//creates new path	
Path(){
	aPath = new int[0][0];
	
}

//adds points (x,y) to path
Path addPoint(int x, int y) {
	count++;
	//copies down old path points to a new path
	int[][] newPath = new int[aPath.length+1][2];
	for(int i = 0; i < aPath.length; i++) {
		newPath[i][0] = aPath[i][0];
		newPath[i][1] = aPath[i][1];
	}
	//adds points x and y to end of new path
	newPath[aPath.length][0] = x;
	newPath[aPath.length][1] = y;
	aPath = newPath;
	return this;
}

//returns i-th point (x,y) 
String getPoint(int i) {
	String thePoint, x, y = new String();
	x = String.valueOf(aPath[i][0]);
	y = String.valueOf(aPath[i][1]);
	thePoint = "(" + x + ", " + y + ")";
	return thePoint;
}

//returns number of points
int numOfPoints() {
	return aPath.length;
}

//removes i-th point from path and returns true
//else returns false
boolean removePoint(int i) {
	if(i < aPath.length) {
		count--;
		int n = 1234;
		aPath[i][0] = n;
		aPath[i][1] = n;
		int[][] newerPath = new int[count][2];
		int k = 0;
		for(int a = 0; a < count; a++) {
			if (k != i) {
			newerPath[k][0] = aPath[a][0];
			newerPath[k][1] = aPath[a][1];
			}
			k++;
		}
		aPath = newerPath;
		return true;
	}
	return false;
}

int[][] getaPath() {
	return aPath;
}

//adds points from Path p to current Path
void addPath(Path p) {
	int newLength = p.numOfPoints() + this.numOfPoints();
	int j = 0;
	int [][] newPath = new int[newLength][2];
	for(int i = 0; i < aPath.length; i++) {
		newPath [i][0] = aPath[i][0];
		newPath [i][1] = aPath[i][1];
	}
	for(int i = aPath.length; i < newLength; i++) {
		newPath [i][0] = p.getaPath()[j][0];
		newPath [i][1] = p.getaPath()[j][1];
		j++;
	}
	aPath = newPath;
}

//returns total lenght of path
double getLength() {
	double totLength = 0;
	for(int i = 1; i < aPath.length; i++) {
		double xdiff = aPath[i][0] - aPath[i-1][0];
		double ydiff = aPath[i][1] - aPath[i-1][1];
		double xSq = Math.pow(xdiff, 2);
		double ySq = Math.pow(ydiff,  2);
		totLength = totLength + Math.sqrt(xSq + ySq);
	}
	return totLength;
}


//returns distance from first to last points
double getDistance() {
	double diffX = aPath[0][0] - aPath[aPath.length - 1][0];
	double diffY = aPath[0][1] - aPath[aPath.length - 1][1];
	double sqX = Math.pow(diffX, 2);
	double sqY = Math.pow(diffY,  2);
	double totalDistance = Math.sqrt(sqX + sqY);
	return totalDistance;
}

//checks if Path current is longer than Path p
boolean isLonger(Path p) {
	//length of current Path
	double currentLength = 0;
	for(int i = 1; i < aPath.length; i++) {
		double xDiff = aPath[i][0] - aPath[i-1][0];
		double yDiff = aPath[i][1] - aPath[i-1][1];
		double xSquare = Math.pow(xDiff, 2);
		double ySquare = Math.pow(yDiff, 2);
		currentLength = currentLength + Math.sqrt(xSquare + ySquare);
	}
	//length of p Path
	double pLength = 0;
	for(int j = 1; j < p.getaPath().length; j++) {
		double xDiff = p.getaPath()[j][0] - p.getaPath()[j-1][0] ;
		double yDiff = p.getaPath()[j][1] - p.getaPath()[j-1][1];
		double xSquare = Math.pow(xDiff, 2);
		double ySquare = Math.pow(yDiff, 2);
		pLength = pLength + Math.sqrt(xSquare + ySquare);
	}
	
	if(currentLength > pLength)
		return true;
	return false;
	
}

}