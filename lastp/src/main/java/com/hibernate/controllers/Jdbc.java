package com.hibernate.controllers;


import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
//import java.sql.*;
import java.util.List;

import org.hibernate.HibernateException;

import com.hibernate.models.*;


/**
 * Servlet implementation class Jdbc
 */

public class Jdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String SERVER="localhost", BD="webscope", LOGIN="user2023", PASSWORD="user2023",VUES="/";
	private static final String VUES="/";
				
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// On devrait récupérer l'action requise par l'utilisateur
			String action = request.getParameter("action");
			// Notre objet modèle: accès à MySQL
			
			TestsHibernate tstHiber;
			 tstHiber = new TestsHibernate();
			// La vue par défaut
			String maVue = VUES + "index.jsp";
			try {
			
					if (action == null) 
					{
						// Rien à faire
					}  else if (action.equals("insertion"))
						{
							/*
							Etudiant monEt = new Etudiant();
							monEt.setNumad(31);
							monEt.setNom("Fall");
							monEt.setPrenom("Cheikh");
							tstHiber.InsertEtu(monEt);
//							*/
						
						try {
							
						
						Artiste art = new Artiste();
						
						art.setNom("Justin");
						art.setPrenom("Bieber");
						art.setAnnee_naissance(1990);
						tstHiber.InsertArt(art);
						request.setAttribute("art", art);	
						
						
						request.setAttribute("insertionReussie", true);
						maVue = VUES + "insertion_confirm.jsp";
						} catch (Exception e) {
						    // Gérer l'échec de l'insertion
						    e.printStackTrace(); // À des fins de débogage, imprimez la trace de la pile
						    request.setAttribute("insertionReussie", false);
						    request.setAttribute("erreurMessage", "Erreur lors de l'insertion : " + e.getMessage());
						    maVue = VUES + "insertion_confirm.jsp";
						}
						}
						// Rediriger vers la page de confirmation

						
						
//						
//						  try {
//                              Film film = new Film();
//                              film.setId(22);
//                              film.setTitre("T1");
//                              film.setAnnee(2033);
//                              film.setId_realisateur(33);
//                              tstHiber.InsertFilm(film);
//                              
//   							maVue = VUES + "connexion.jsp";
//                          
//						} catch (Exception e) {
//							throw new RuntimeException("error : "
//									+ e.getMessage(), e);
//						}
//							maVue = VUES + "connexion.jsp";
//						}
					 else if (action.equals("pays"))
					 {											 
				List<Pays> resultat = tstHiber.lecturePaysHQL();
						 request.setAttribute("paysList", resultat);
						 maVue = VUES + "pays.jsp";	
					 }
						 else if (action.equals("artistes"))
					 {
						 List<Artiste> resultat = tstHiber.lectureArtHQL();
						 request.setAttribute("artistes", resultat);
						 maVue = VUES + "artistes.jsp";	
					 }
						 else if (action.equals("lister"))
						 {
							
						
//						System.out.print(films);
						
                      try {
                    	  List<Film> films = tstHiber.lectureFlmHQL();
                    	  
                    	  try {
                    		    for (Iterator iterator = films.iterator(); iterator.hasNext();) {
                    		        Film f = (Film) iterator.next();
                    		        System.out.print("ID " + f.getId_realisateur());
                    		        System.out.print("Password " + f.getAnnee() );
                    		        System.out.print("Fullname " + f.getTitre());

                    		    }
                    		} catch (HibernateException e) {
                    		    
                    		}
  						request.setAttribute("films", films);
  						maVue = VUES + "films.jsp";	
                      }
                      catch (Exception e) {
      					throw new RuntimeException("Erreur filmm.... : "
      							+ e.getMessage(), e);
                      }
									
					}
						 else if (action.equals("region"))
						 {
							
						List<Region> regions = tstHiber.lectureRegHQL();
						request.setAttribute("regions", regions);
						maVue = VUES + "regions.jsp";	
									
					}
				} catch (Exception e) {
					throw new RuntimeException("Erreur.... : "
							+ e.getMessage(), e);
//			maVue = VUES + "exceptions.jsp";
//			request.setAttribute("message",e.getMessage());
			}
			// On transmet à la vue
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(maVue);
			dispatcher.forward(request, response);
			}
			}

