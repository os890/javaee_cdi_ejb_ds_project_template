# CDI / EJB / DeltaSpike Project Template

A project template showing how CDI, EJB and [Apache DeltaSpike](https://deltaspike.apache.org/)
work together. An `@ApplicationScoped` CDI bean injects a `@Stateless` EJB via `@EJB`,
and the whole stack is covered by two complementary test approaches.

## Key Technologies

| Technology | Version | Purpose |
|---|---|---|
| Jakarta CDI | 4.1 | Dependency injection |
| Jakarta EJB | 4.0 | Stateless session bean |
| Apache DeltaSpike | 2.0.0 | CDI extensions (core API + impl) |
| TomEE / OpenEJB | 10.1.4 | Embedded EJB container for integration tests |
| [Dynamic CDI Test Bean Addon](https://github.com/os890/dynamic-cdi-test-bean-addon) | 1.0.0-SNAPSHOT | Lightweight CDI SE testing with auto-mocking |
| JUnit Jupiter | 6.0.3 | Test framework |
| Java | 25+ | Runtime |

## Project Structure

```
src/main/java/org/os890/cdi/template/
    ApplicationScopedBean.java   @ApplicationScoped CDI bean, injects StatelessEJB via @EJB
    StatelessEJB.java            @Stateless EJB service

src/test/java/org/os890/cdi/test/
    SimpleTest.java              TomEE embedded test (EJBContainer) — full EJB + CDI stack
    CdiTest.java                 CDI SE test (@EnableTestBeans) — lightweight, no EJB container
```

## Build

```bash
mvn clean verify
```

## Test Profiles

TomEE embedded and CDI SE (OpenWebBeans SE) use incompatible container configurations,
so each test has its own Maven profile:

| Profile | Command | Test | Container |
|---|---|---|---|
| `cdi` (default) | `mvn clean verify` | CdiTest | OWB SE + Dynamic CDI Test Bean Addon |
| `tomee` | `mvn clean verify -Ptomee` | SimpleTest | TomEE / OpenEJB 10.1.4 embedded |

To run both:

```bash
mvn clean verify && mvn verify -Ptomee
```

## Quality Gates

All gates run during `validate` / `test` and must pass for a successful build:

- **Enforcer** — Java 25+, Maven 3.6.3+, no `javax.*` dependencies
- **Checkstyle** — Allman brace style, no star imports, consistent whitespace
- **RAT** — Apache License 2.0 header on all source and config files
- **Compiler** — `-Xlint:all`, fail on warnings
- **JaCoCo** — code coverage report

## License

[Apache License, Version 2.0](LICENSE)
