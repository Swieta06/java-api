package com.onetoone.service;

import com.onetoone.repository.MobilRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MobilServiceImplTest {

    @Mock
    private MobilRepository mobilRepository;

    @InjectMocks
    private MobilServiceImpl mobilService;

    @Test
    public void getAllTest() {
        mobilService.getAll(1, 2);
    }

}
