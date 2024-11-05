package org.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.model.Developer;

import java.util.List;

@Mojo(name = "show-developers")
public class DeveloperInfoMojo extends AbstractMojo {


    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        List<Developer> developers = project.getDevelopers();

        if (developers.isEmpty()) {
            getLog().info("Нет информации о разработчиках.");
        } else {
            getLog().info("Информация о разработчиках:");
            for (Developer developer : developers) {
                getLog().info("ID: " + developer.getId());
                getLog().info("Имя: " + developer.getName());
                getLog().info("Email: " + developer.getEmail());
                getLog().info("Организация: " + developer.getOrganization());
                getLog().info("Роли: " + String.join(", ", developer.getRoles()));
            }
        }
    }

}
