package estudianteController;


@RestController
@RequestMapping("/estudiantes")
public class estudianteController {

	@Autowired
	private estudianteRepository estudianteRepositoryImpl;
}
