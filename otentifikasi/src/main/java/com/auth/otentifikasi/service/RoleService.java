package com.auth.otentifikasi.service;

import com.auth.otentifikasi.dto.RoleDto;

public interface RoleService {
    RoleDto create(RoleDto roleDto) throws Exception;
}
