package com.trey.marvel.model.api.manager;

import com.trey.marvel.model.api.MarvelApi;
import com.trey.marvel.model.api.request.ComicRequest;
import com.trey.marvel.model.api.request.CreatorRequest;
import com.trey.marvel.model.api.request.EventRequest;
import com.trey.marvel.model.api.request.SeriesRequest;
import com.trey.marvel.model.api.request.StoryRequest;
import com.trey.marvel.model.api.response.ServiceResponse;
import com.trey.marvel.model.api.service.Creators;
import com.trey.marvel.model.api.vo.Comic;
import com.trey.marvel.model.api.vo.Creator;
import com.trey.marvel.model.api.vo.Event;
import com.trey.marvel.model.api.vo.Series;
import com.trey.marvel.model.api.vo.Story;

import retrofit.Callback;

/**
 * Created by Trey Robinson on 2/21/14.
 */
public class CreatorManager extends BaseManager {

    private Creators creators;

    public CreatorManager() {
        creators = MarvelApi.getInstance().getRestAdapter().create(Creators.class);
    }

    public void listCreators(CreatorRequest request, Callback<ServiceResponse<Creator>> callback) {
        creators.listCreators(request.getLimit()
                , request.getOffset()
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , request.getFirstName()
                , request.getMiddleName()
                , request.getLastName()
                , request.getSuffix()
                , request.getModifiedSince()
                , parameterizeList(request.getComics())
                , parameterizeList(request.getSeries())
                , parameterizeList(request.getStories())
                , request.getOrderBy().getValue()
                , callback);
    }

    public void getCreatorWithId(int creatorId, CreatorRequest request, Callback<ServiceResponse<Creator>> callback) {
        creators.getCreatorWithId(creatorId
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , callback);
    }

    public void getComicsForCreatorId(int creatorId, ComicRequest request, Callback<ServiceResponse<Comic>> callback) {
        creators.getComicsForCreatorId(creatorId
                , request.getLimit()
                , request.getOffset()
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , request.getFormat().getValue()
                , request.getFormatType().getValue()
                , request.isNoVariants()
                , request.getDateDescriptor().getValue()
                , request.getDateRange()
                , request.isHasDigitalIssue()
                , request.getModifiedSince()
                , parameterizeList(request.getCreators())
                , parameterizeList(request.getSeries())
                , parameterizeList(request.getEvents())
                , parameterizeList(request.getStories())
                , parameterizeList(request.getSharedAppearances())
                , parameterizeList(request.getCollaborators())
                , request.getOrderBy().getValue(), callback);
    }

    public void getEventsForCreatorId(int creatorId, EventRequest request, Callback<ServiceResponse<Event>> callback) {
        creators.getEventsForCreatorId(creatorId
                , request.getLimit()
                , request.getOffset()
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , request.getName()
                , request.getModifiedSince()
                , parameterizeList(request.getCreators())
                , parameterizeList(request.getCharacters())
                , parameterizeList(request.getSeries())
                , parameterizeList(request.getStories())
                , request.getOrderBy().getValue()
                , callback);
    }

    public void getSeriesForCreatorId(int creatorId, SeriesRequest request, Callback<ServiceResponse<Series>> callback) {
        creators.getSeriesForCreatorId(creatorId
                , request.getLimit()
                , request.getOffset()
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , request.getTitle()
                , request.getModifiedSince()
                , parameterizeList(request.getComics())
                , parameterizeList(request.getStories())
                , parameterizeList(request.getEvents())
                , parameterizeList(request.getCreators())
                , request.getSeriesType().getValue()
                , request.getContains().getValue()
                , request.getOrderBy().getValue()
                , callback);
    }

    public void getStoriesForComicId(int comicId, StoryRequest request, Callback<ServiceResponse<Story>> callback) {
        creators.getStoriesForCreatorId(comicId
                , request.getLimit()
                , request.getOffset()
                , String.valueOf(request.getTimestamp())
                , request.getApiKey()
                , request.getHashSignature()
                , request.getModifiedSince()
                , parameterizeList(request.getSeries())
                , parameterizeList(request.getEvents())
                , parameterizeList(request.getCreators())
                , parameterizeList(request.getCharacters())
                , request.getOrderBy().getValue()
                , callback);
    }
}
