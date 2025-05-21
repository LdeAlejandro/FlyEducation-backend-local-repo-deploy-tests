-- Insert the admin profile, ignore if exists
INSERT INTO perfiles (perfil_id, name) 
VALUES (1, 'admin') 
ON CONFLICT (perfil_id) DO NOTHING;

-- Insert the aluno profile, ignore if exists
INSERT INTO perfiles (perfil_id, name) 
VALUES (2, 'aluno') 
ON CONFLICT (perfil_id) DO NOTHING;


DELETE FROM usuario_perfil WHERE usuario_id NOT IN (SELECT id FROM usuarios_base);