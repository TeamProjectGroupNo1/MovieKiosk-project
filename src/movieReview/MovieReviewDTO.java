package movieReview;

public class MovieReviewDTO {
	private String id;
	private String movieName;
	private double starRate;
	private String movieComment;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getMovieName() { return movieName; }
	public void setMovieName(String movieName) { this.movieName = movieName; }
	public double getStarRate() { return starRate; }
	public void setStarRate(double starRate) { this.starRate = starRate; }
	public String getMovieComment() { return movieComment; }
	public void setMovieComment(String movieComment) { this.movieComment = movieComment; }
}
