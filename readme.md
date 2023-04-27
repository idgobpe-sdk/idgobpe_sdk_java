# IDGOB.PE Java SDK

## 1. Instalación:

```
<dependency>
    <groupId>io.github.gobpe-sdks</groupId>
    <artifactId>idgobpe_sdk_java</artifactId>
    <version>1.0.4</version>
</dependency>
```

## 2. Gestor de dependecias

[Maven central repository](https://search.maven.org/search?q=g:io.github.gobpe-sdks)

## 3. Configuración

### ACR disponibles

```
Acr.ONE_FACTOR
Acr.TWO_FACTOR
Acr.CERTIFICATE_DNIE
Acr.CERTIFICATE_TOKEN
Acr.CERTIFICATE_DNIE_LEGACY
Acr.CERTIFICATE_TOKEN_LEGACY
```

### Prompt disponibles

```
Prompt.NONE
Prompt.LOGIN
Prompt.CONSENT
```

### Scope disponibles

```
Scope.PROFILE
Scope.EMAIL
Scope.PHONE
Scope.OFFLINE_ACCESS
```

## 4. Documentación de OpenID Connect

[https://openid.net/specs/openid-connect-core-1_0.html](https://openid.net/specs/openid-connect-core-1_0.html)