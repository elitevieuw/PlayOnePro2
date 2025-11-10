PlayOne IPTV
Introductie
PlayOne IPTV is een toekomstbestendige universele multi-platform app voor IPTV met live TV, VoD, EPG, recording, favorites en parental control.

Overzicht
PlayOne IPTV is een universele, multi-platform IPTV-applicatie ontworpen voor Android TV, iOS/tvOS, webOS, Tizen, en een krachtige backend (Node.js met GraphQL). De app ondersteunt live TV streaming, video on demand (VoD), elektronische programmagids (EPG), DVR-functies zoals opnemen en offline afspelen, favorieten en ouderlijk toezicht. Dit alles ingebouwd in een future-proof, modulair mono-repo met Nx.

Technologie Stack
Frontend apps:
Android TV & Fire TV: Kotlin Multiplatform met Compose TV
iOS/tvOS: SwiftUI & Combine
webOS, Tizen, Vidaa: ReactTV/Enact & TypeScript
Roku: BrightScript & SceneGraph
Backend: Node.js met GraphQL API, PostgreSQL database en Redis caching, containerized met Docker & Kubernetes
CI/CD pipeline: GitHub Actions voor build, linting, unit- en UI-tests, security scans, en multi-platform distributie
AI-integratie: AI-tools zoals GitHub Copilot en Xcode AI Assistant worden gebruikt voor foutloze, snelle codegeneratie en security toolings zoals Snyk voor kwetsbaarheidsanalyse.
Projectstatus en Voortgang
Mono-repo en basismodules opgezet (authenticatie, streaming, UI componenten)
Basisstreaming (HLS/DASH) en OAuth2 login geïmplementeerd met adaptive bitrate en JWT-tokenbeheer
Eerste MVP UI ontworpen met remote-navigatie en focusbeheer, gebruikmakend van AI-UI prototyping tools
Testinfrastructuur opgezet met unit tests >80% coverage en end-to-end testen op real devices
Security en performance geoptimaliseerd met AI-ondersteuning
Volgende stappen: DVR-functionaliteit uitbreiden, EPG optimaliseren, parental control implementeren, platform specifieke integraties finaliseren
Hoe mee te ontwikkelen
Clone deze repo
Volg de setupinstructies per platform in /docs
Gebruik AI-assistenten zoals GitHub Copilot voor consistente codekwaliteit
Doe regelmatige pull requests met duidelijke commit messages volgens de conventies
Run CI/CD pipelines en tests vóór merge
Contact
Voor vragen en samenwerking: eliteview@playoneapp.com

License
MIT License © 2025 PlayOne IPTV
