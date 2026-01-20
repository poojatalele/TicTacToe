# DevSecOps CI/CD Pipeline  


---

## 1. Problem Background & Motivation

Modern software systems require more than just compiling and running code. Production environments demand **automation, security, reproducibility, and traceability** across the entire software delivery lifecycle.

### Industry Challenges Addressed
- CI pipelines that only compile code without enforcing quality or security  
- Docker images built without vulnerability scanning  
- Tight coupling of CI and CD pipelines  
- Lack of traceability between source code and deployed artifacts  
- Manual or ad-hoc Kubernetes deployments  

These gaps increase the risk of:
- Supply-chain attacks  
- Runtime vulnerabilities  
- Undetected regressions  
- Deployment inconsistencies  

### Motivation
This project focuses on **pipeline correctness rather than application complexity**. By applying production-grade DevSecOps practices to a simple CLI application, it demonstrates:
- Why each pipeline stage exists  
- What risk it mitigates  
- How it improves deployment confidence  

---

## 2. Application Overview

### Application Description
The application is a **Java-based Tic-Tac-Toe Command Line Interface (CLI)**.

| Attribute | Description |
|--------|------------|
| Language | Java |
| Interface | Terminal (CLI) |
| Execution Model | Interactive |
| Input | STDIN |
| Output | STDOUT |
| Networking | None |

### Why This Application is DevOps-Relevant
Unlike typical web applications:
- No exposed ports  
- No Kubernetes Service required  
- Interaction happens via STDIN/STDOUT  

This enforces **correct Kubernetes abstraction usage**.

---

## 3. CI/CD Workflow Diagram

Developer Push / Pull Request  
↓  
GitHub Actions – CI  
- Code Checkout  
- Java Setup  
- Compile  
- Unit Tests  
- Static Code Analysis  
- Docker Build  
- Image Vulnerability Scan  
- Image Push  

↓  
Container Registry  

↓  
GitHub Actions – CD  
- Kubernetes Authentication  
- Deployment Apply  
- Rollout Validation  

↓  
Kubernetes Cluster  

---

## 4. Security & Quality Controls

- Static Code Analysis  
- Unit Testing  
- Docker Image Vulnerability Scanning  

Security and quality are enforced early (Shift-Left DevSecOps).

---

## 5. Results & Observations

### Outcomes Achieved
- Fully automated CI pipeline  
- Secure containerized Java CLI application  
- Kubernetes-based deployment  
- Separation of CI and CD  

### Key Observations
- Kubernetes supports non-web workloads  
- Pipeline design matters more than tool count  

---

## 6. Limitations & Improvements

### Limitations
- Manual pod attachment  
- No persistent storage  

### Improvements
- GitOps-based CD  
- Policy-as-Code  
- Observability integration  

---

## 7. Final Conclusion

This project demonstrates that **production-grade DevSecOps practices apply to all workloads**, including CLI applications.

---

## 8. Repository Structure

```
.
├── .github/workflows/
│   ├── ci.yml
│   └── cd.yml
├── src/
├── Dockerfile
├── deployment.yaml
├── pom.xml
└── README.md
```

---

## 9. Steps to Run

### Local
```
mvn clean package
java -jar target/tictactoe.jar
```

### Docker
```
docker build -t tictactoe .
docker run -it tictactoe
```

### Kubernetes
```
kubectl apply -f deployment.yaml
kubectl attach -it <pod-name>
```

---

## 10. Secrets Configuration

Configured in GitHub Actions:
- DOCKER_USERNAME
- DOCKER_PASSWORD
- KUBE_CONFIG

---

## 11. CI Explanation

CI runs on push and pull requests:
- Build
- Test
- Scan
- Package
- Push image

Only verified artifacts proceed to deployment.
