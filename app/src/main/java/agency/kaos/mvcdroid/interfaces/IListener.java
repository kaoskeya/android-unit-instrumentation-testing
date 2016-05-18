package agency.kaos.mvcdroid.interfaces;

/**
 * Created by keya on 18/05/16.
 */
public interface IListener<T> {

    void onSuccess(T t);
    void onFailure(String errorMessage);

}
