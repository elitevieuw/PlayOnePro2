# PlayOnePro2

## Introductie

PlayOnePro2 is een geavanceerde universele multi-platform mediaplayer app voor het afspelen van video's, muziek en andere media content.

## Overzicht

PlayOnePro2 is een universele, multi-platform mediaplayer applicatie ontworpen voor Android TV, iOS/tvOS, webOS, Tizen, en andere smart TV platforms. De app ondersteunt verschillende mediaformaten en biedt een gebruiksvriendelijke interface voor het afspelen van lokale en online content.

## Technologie Stack

**Frontend apps:**
- Android TV & Fire TV: Kotlin Multiplatform met Compose TV
- iOS/tvOS: SwiftUI & Combine
- webOS, Tizen, Vidaa: ReactTV/Enact & TypeScript
- Roku: BrightScript & SceneGraph

**Backend:** Node.js met GraphQL API, PostgreSQL database en Redis caching, containerized met Docker & Kubernetes

**CI/CD pipeline:** GitHub Actions voor build, linting, unit- en UI-tests, security scans, en multi-platform deployment

**AI-integratie:** AI-tools zoals GitHub Copilot en Xcode AI Assistant worden gebruikt voor snelle en betrouwbare ontwikkeling

## Projectstatus en Voortgang

- Mono-repo en basismodules opgezet (authenticatie, streaming, UI componenten)
- Basisstreaming (HLS/DASH) geïmplementeerd met adaptive bitrate
- Eerste MVP UI ontworpen met remote-navigatie en focusbeheer
- Testinfrastructuur opgezet met unit tests >80% coverage
- Security en performance geoptimaliseerd
- Volgende stappen: Uitbreiding mediaformaten, playlist functionaliteit, offline playback

## Hoe mee te ontwikkelen

1. Clone deze repo
2. Volg de setupinstructies per platform in /docs
3. Gebruik AI-assistenten zoals GitHub Copilot voor consistente codekwaliteit
4. Doe regelmatige pull requests met duidelijke commit messages
5. Run CI/CD pipelines en tests vóór merge

## Contact

Voor vragen en samenwerking: contact@playoneapp.com

## License

MIT License © 2025 PlayOnePro2
