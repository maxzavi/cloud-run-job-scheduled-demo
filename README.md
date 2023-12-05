# Demo GCP Cloud Run Job and GCP Cloud Scheduler

## Spring Boot project

Create Spring Boot project, using starter Lombok.

Build dist:

```cmd
sh mvnw package
```


## GCP

Official documentation: https://cloud.google.com/artifact-registry/docs/docker/pushing-and-pulling?hl=es-419

Create repository in Artifact Registry: **demo**

Create imagen using tag by gcr artifact registry: replace region, project id, repository, image name and tag:

```cmd
docker build -t us-central1-docker.pkg.dev/temporal-283603/demo/helloworld:0 .
```

Login in artifact repository using key by service account, asign roles:

- Artifact Registry Writer
- Storage Admin

```cmd
cat keys/gcp_key.json | docker login -u _json_key --password-stdin \
https://us-central1-docker.pkg.dev
```

Push image to Artifact Registry:

```cmd
docker push us-central1-docker.pkg.dev/temporal-283603/demo/helloworld:0
```

Create Cloud Run Job using image, and schedule with crontab expresion
