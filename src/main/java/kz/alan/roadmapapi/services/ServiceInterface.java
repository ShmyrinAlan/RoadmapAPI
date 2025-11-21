package kz.alan.roadmapapi.services;

import java.util.List;

public interface ServiceInterface<MAIN, OUT, ID> {
    OUT create(MAIN dto);
    List<OUT> read();
    OUT read(ID id);
    OUT update(ID id, MAIN dto);
    OUT updatePartial(ID id, MAIN dto);
    boolean delete(ID id);
}
