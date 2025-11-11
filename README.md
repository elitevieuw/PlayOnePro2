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

## CI/CD Setup en Configuratie

Deze repository bevat een complete CI/CD pipeline met GitHub Actions voor geautomatiseerde build, test en deployment processen.

### Workflow Overzicht

Er zijn twee hoofdworkflows geconfigureerd:

1. **CI Workflow (`ci.yml`)** - Continuous Integration
   - **Trigger**: Elke push naar `main` branch en elke pull request naar `main`
   - **Jobs**:
     - 🧹 **Lint**: Code style checks met `./gradlew lintDebug`
     - 🧪 **Test**: Unit tests met `./gradlew testDebugUnitTest`
     - 🔨 **Build**: Debug APK bouwen met `./gradlew assembleDebug`
     - ✅ **CI Status**: Controleert of alle jobs succesvol zijn

2. **CD Workflow (`release.yml`)** - Continuous Deployment
   - **Trigger**: Push van version tags (bijv. `v1.0.0`, `v2.1.3`)
   - **Jobs**:
     - 📦 **Build Release**: Bouwt ondertekende APK en AAB
     - 🚀 **Create GitHub Release**: Maakt GitHub release met artifacts
     - 📱 **Deploy to Play Store**: Upload naar Google Play (internal track)
     - ✅ **Release Status**: Rapporteert deployment status

### Vereiste GitHub Secrets

Voor het correct functioneren van de CD pipeline moeten de volgende secrets worden geconfigureerd in GitHub:

#### Stap 1: Navigeer naar Secrets

1. Ga naar je repository op GitHub
2. Klik op **Settings** → **Secrets and variables** → **Actions**
3. Klik op **New repository secret**

#### Stap 2: Configureer Signing Secrets

Voeg de volgende secrets toe voor het ondertekenen van de release APK/AAB:

**`KEYSTORE_BASE64`**
- **Wat**: Base64-gecodeerde versie van je Android keystore file
- **Hoe te verkrijgen**:
  ```bash
  # Op Linux/Mac
  base64 -i your-keystore.jks | tr -d '\n' > keystore_base64.txt
  
  # Op Windows (PowerShell)
  [Convert]::ToBase64String([IO.File]::ReadAllBytes("your-keystore.jks")) | Out-File keystore_base64.txt
  ```
- **Gebruik**: Keystore wordt gedecode tijdens build proces

**`KEYSTORE_PASSWORD`**
- **Wat**: Het wachtwoord voor je keystore file
- **Voorbeeld**: `MijnVeiligKeyStoreWachtwoord123`

**`KEY_ALIAS`**
- **Wat**: De alias naam van je signing key in de keystore
- **Voorbeeld**: `playonepro-release-key`

**`KEY_PASSWORD`**
- **Wat**: Het wachtwoord voor je specifieke key alias
- **Voorbeeld**: `MijnVeiligKeyWachtwoord456`

#### Stap 3: Configureer Play Store Deployment (Optioneel)

Voor automatische deployment naar Google Play Console:

**`PLAY_STORE_JSON_KEY`**
- **Wat**: Service account JSON key voor Google Play API toegang
- **Hoe te verkrijgen**:
  1. Ga naar [Google Play Console](https://play.google.com/console)
  2. Navigeer naar **Setup** → **API access**
  3. Maak een service account aan of gebruik bestaande
  4. Download de JSON key file
  5. Kopieer de volledige inhoud van de JSON file
- **Gebruik**: Authenticatie voor upload naar Play Store

### CI/CD Pipeline Gebruiken

#### Automatische CI Tests

De CI pipeline draait automatisch bij:
- Elke push naar `main` branch
- Elke pull request targeting `main` branch

**Geen actie vereist** - GitHub Actions detecteert wijzigingen en start de workflow.

#### Release Maken en Deployen

Om een nieuwe release te maken en te deployen:

1. **Zorg dat alle wijzigingen zijn gecommit en gepushed naar `main`**

2. **Maak een version tag**:
   ```bash
   # Formaat: v<MAJOR>.<MINOR>.<PATCH>
   git tag v1.0.0
   git push origin v1.0.0
   ```

3. **CD Workflow start automatisch**:
   - Bouwt ondertekende APK en AAB
   - Upload artifacts naar GitHub Release
   - (Optioneel) Deploy naar Google Play internal track

4. **Monitor de workflow**:
   - Ga naar **Actions** tab in GitHub
   - Klik op de actieve workflow run
   - Bekijk real-time logs en status

### Workflow Status Monitoren

**In GitHub:**
1. Ga naar de **Actions** tab in je repository
2. Zie alle workflow runs met status indicators:
   - ✅ Groene vinkje = Succesvol
   - ❌ Rode X = Gefaald
   - 🟡 Gele cirkel = Actief/Running
3. Klik op een workflow run voor gedetailleerde logs

**Build Artifacts Downloaden:**
- Na succesvolle build zijn APK/AAB files beschikbaar in:
  - **GitHub Actions**: Artifacts sectie onderaan de workflow run pagina
  - **GitHub Releases**: Voor CD workflows met version tags

### Troubleshooting

**❌ Build faalt met "Keystore not found"**
- Controleer of `KEYSTORE_BASE64` secret correct is geconfigureerd
- Verifieer dat de base64 encoding geen newlines bevat

**❌ "Invalid keystore format"**
- Zorg dat je een `.jks` of `.keystore` file gebruikt (geen `.pem` of andere formats)
- Controleer keystore integriteit met: `keytool -list -keystore your-keystore.jks`

**❌ Play Store upload faalt**
- Verifieer dat service account correcte permissions heeft in Play Console
- Controleer dat `PLAY_STORE_JSON_KEY` de volledige JSON structuur bevat
- Zorg dat de app al bestaat in Play Console (eerste upload moet manueel)

**❌ Test failures**
- CI workflow zal falen als unit tests niet slagen
- Bekijk de test logs in de Actions tab
- Run tests lokaal: `./gradlew testDebugUnitTest`

### Security Best Practices

- ✅ **NOOIT** keystore files, wachtwoorden of API keys committen in de repository
- ✅ Gebruik **ALTIJD** GitHub Secrets voor gevoelige informatie
- ✅ Roteer credentials regelmatig (elk kwartaal aanbevolen)
- ✅ Beperk toegang tot repository secrets tot noodzakelijke team members
- ✅ Gebruik verschillende keystores voor debug en release builds
- ✅ Backup je keystore file veilig - verlies betekent geen updates meer kunnen pushen!


## Contact

Voor vragen en samenwerking: contact@playonepro.com

## License

MIT License © 2025 PlayOnePro2
