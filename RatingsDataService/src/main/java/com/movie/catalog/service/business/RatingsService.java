package com.movie.catalog.service.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.catalog.service.entities.MovieEntity;
import com.movie.catalog.service.entities.RatingEntity;
import com.movie.catalog.service.entities.UserRatingEntity;
import com.movie.catalog.service.pojos.Rating;
import com.movie.catalog.service.pojos.UserRating;
import com.movie.catalog.service.repositories.RatingsRepository;

@Service
public class RatingsService {
	
	@Autowired
	RatingsRepository ratingsrepo;
	
	public List<Rating> fetchRatings(int movieId) {
		List<RatingEntity> ratings = ratingsrepo.findByMovieId(movieId);
		List<Rating> rts = new ArrayList<>();
		for (RatingEntity re : ratings) {
			Rating rating = new Rating();
			rating.setMovieId(Integer.parseInt(re.getMovy().getMovieId()+""));
			rating.setRating(Float.parseFloat(re.getRating()+""));
			rts.add(rating);
		}
		return rts;
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void saveMovieRating(UserRating rating) {
		
		List<RatingEntity> ratingsSaved =  new ArrayList<>();
		for (Rating movieRating : rating.getRatings()) {
			
			RatingEntity rEntity = new RatingEntity();
			rEntity.setRating(BigDecimal.valueOf(Double.parseDouble(movieRating.getRating()+"")));
			MovieEntity mEntity = new MovieEntity();
			mEntity.setMovieId(movieRating.getMovieId());
			rEntity.setMovy(mEntity);
			
			ratingsrepo.saveRating(rEntity);
			
			ratingsSaved.add(rEntity);
		}
		
		for (RatingEntity savedEntity : ratingsSaved) {
			UserRatingEntity urentity = new UserRatingEntity();
			urentity.setUserId(BigDecimal.valueOf(Long.parseLong(rating.getUserId())));
			urentity.setRating(savedEntity);
			
			ratingsrepo.saveUserRating(urentity);
		}
	}
}
