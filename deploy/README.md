# LibraryApp

As the README describes, you can reuse the Docker daemon from Minikube with eval $(minikube docker-env).

So to use an image without uploading it, you can follow these steps:

    Set the environment variables with eval $(minikube docker-env)
    Build the image with the Docker daemon of Minikube (eg docker build -t my-image .)
    Set the image in the pod spec like the build tag (eg my-image)
    Set the imagePullPolicy to Never, otherwise Kubernetes will try to download the image.
