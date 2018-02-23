/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.services.ws;

import book.store.cons.BookData;
import book.store.cons.FilterData;
import book.store.dao.BookStoreDao;
import book.store.dao.DatabaseDaoFactory;
import book.store.daoutils.DaoUtils;
import book.store.daoutils.DateFormatterUtil;
import book.store.entity.BookStoreEntity;
import book.store.enums.ServiceStatus;
import book.store.resp.BookStoreListResp;
import book.store.resp.DefaultResp;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author joel
 */
@Path("BookStore")
public class BookStoreResources {
    private static final Logger LOG = LoggerFactory.getLogger(BookStoreResources.class);
    private static DatabaseDaoFactory daoFactory = DaoUtils.getDatabaseDaoFactory();
    private Gson gson = new Gson();
    private DateFormatterUtil dtf = new DateFormatterUtil();
    private BookStoreEntity entity = new BookStoreEntity();
    private List<BookStoreEntity> entList = new ArrayList<BookStoreEntity>();
    private List<BookData> listData = new ArrayList<BookData>();
    private BookData allData = new BookData();
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("FilterByData")
    public BookStoreListResp filterByData(FilterData data){
        BookStoreListResp retval = null;
        LOG.debug("user input: "+gson.toJson(data));
        BookStoreDao dao = daoFactory.getBookStoreDao();
        try{
                if(data.getDate()!=null){
                    entList = dao.getAllBooksbyDate(data.getDate());
                    if(entList.size()>0){
                        for(BookStoreEntity ent : entList){
                            String payload = gson.toJson(ent);
                            allData = gson.fromJson(payload,BookData.class);
                            listData.add(allData);
                        }
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        //for break
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                    }
                }else if(data.getGenre()!=null){
                    entList = dao.getAllBooksbyGenre(data.getGenre());
                    if(entList.size()>0){
                        for(BookStoreEntity ent : entList){
                            String payload = gson.toJson(ent);
                            allData = gson.fromJson(payload,BookData.class);
                            listData.add(allData);
                        }
                        //for break
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                    }
                }else if(data.getAuthor()!=null){
                    entList = dao.getAllBooksbyAuthor(data.getAuthor());
                    if(entList.size()>0){
                        for(BookStoreEntity ent : entList){
                            String payload = gson.toJson(ent);
                            allData = gson.fromJson(payload,BookData.class);
                            listData.add(allData);
                        }
                        //for break
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                    }
                }else if(data.getTittle()!=null){
                    entList = dao.getAllBooksbyTittle(data.getTittle());
                    if(entList.size()>0){
                        for(BookStoreEntity ent : entList){
                            String payload = gson.toJson(ent);
                            allData = gson.fromJson(payload,BookData.class);
                            listData.add(allData);
                        }
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        //for break
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                    }
                }else if(data.getPrice()>0){
                    entList = dao.getAllBooksbyPrice(data.getPrice());
                    if(entList.size()>0){
                        for(BookStoreEntity ent : entList){
                            String payload = gson.toJson(ent);
                            allData = gson.fromJson(payload,BookData.class);
                            listData.add(allData);
                        }
                        //for break
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                    }
                }else if(data.getLimitBy()>0){
                    entList = dao.getAllBooks();
                    if(entList.size()>0){
                        for(int i= 0; i< data.getLimitBy(); i++){
                            allData.setBookAuthor(entList.get(i).getBookAuthor());
                            allData.setBookGenre(entList.get(i).getBookGenre());
                            allData.setBookId(entList.get(i).getBookId());
                            allData.setBookTittle(entList.get(i).getBookTittle());
                            allData.setCreatedBy(entList.get(i).getCreatedBy());
                            allData.setCreatedDate(entList.get(i).getCreatedDate());
                            allData.setLastModBy(entList.get(i).getCreatedBy());
                            allData.setLastModDate(entList.get(i).getLastModDate());
                            allData.setPrice(entList.get(i).getPrice());
                            listData.add(allData);
                        }
                        //for break
                        LOG.debug("Successful filter request! "+gson.toJson(listData));
                        retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Successful filter request! ");
                        data.setAuthor(null);
                        data.setDate(null);
                        data.setGenre(null);
                        data.setLimitBy(0);
                        data.setPrice(0);
                        data.setTittle(null);
                    }else{
                        LOG.debug("need filter request! ");
                        retval = new BookStoreListResp(ServiceStatus.FAILED,"need filter request! ");
                    }
                }
                
        }catch(Throwable t){
            LOG.debug("Error in finding books! "+t.getLocalizedMessage());
            retval = new BookStoreListResp(ServiceStatus.ERROR,"finding books! "+t.getLocalizedMessage());
        }finally{
            dao.close();
        }
        return retval;
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ShowAllBooks")
    public BookStoreListResp showAllBooks(){
        BookStoreListResp retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        try{
            entList = dao.getAllBooks();
            if(entList.size()>0){
                for(BookStoreEntity ent : entList){
                    String payload = gson.toJson(ent);
                    allData = gson.fromJson(payload,BookData.class);
                    listData.add(allData);
                }
                LOG.debug("Successful request! "+gson.toJson(listData));
                retval = new BookStoreListResp(listData,ServiceStatus.SUCCESS,"Sucess finding in books data! ");
            }else{
                LOG.debug("Failed finding in books data! ");
                retval = new BookStoreListResp(ServiceStatus.FAILED,"finding in books data! ");
            }
        }catch(Throwable t){
            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
                retval = new BookStoreListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
        }finally{
            dao.close();
        }
        
        return retval;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("AddBooks")
    public DefaultResp<BookData> save(BookData data){
        DefaultResp retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        LOG.debug("user input: "+gson.toJson(data));
        try{
            if(data.getBookAuthor()!=null && data.getBookGenre()!=null
                    && data.getBookTittle()!=null && data.getCreatedBy()!=null
                    && data.getPrice()>0){
                entity.setBookAuthor(data.getBookAuthor());
                entity.setBookGenre(data.getBookGenre());
                entity.setBookId(null);
                entity.setBookTittle(data.getBookTittle());
                entity.setCreatedBy(data.getCreatedBy());
                entity.setPrice(data.getPrice());
                entity.setCreatedDate(dtf.convertDate(new Date()));
                entity.setLastModBy(data.getCreatedBy());
                entity.setLastModDate(dtf.convertDate(new Date()));
                dao.save(entity);
                LOG.debug("Successful saving of books!");
                retval = new DefaultResp(ServiceStatus.SUCCESS,"Successful saving of books!");
            }else{
                LOG.debug("Failed some fields are empty!");
                retval = new DefaultResp(ServiceStatus.FAILED," Failed some fields are empty!");
            }
        }catch(Throwable t){
            LOG.debug("Error in saving data! "+t.getLocalizedMessage());
            retval = new DefaultResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
        }finally{
            dao.close();
        }
        
        
        return retval;
    }
    
    // TAG stands for Tittle  Author And Genre
    // only tag can update 
    // as for instruction "Rename a tag"
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("RenameTag")
    public DefaultResp<BookData> renameTag(BookData data){
        DefaultResp retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        LOG.debug("user input: "+gson.toJson(data));
        try{
            BookStoreEntity entity1 = dao.findById(data.getBookId());
            
            if(entity1!=null){
                entity1.setBookAuthor(data.getBookAuthor()!=null ? data.getBookAuthor() : entity1.getBookAuthor());
                entity1.setBookGenre(data.getBookGenre()!=null ? data.getBookGenre() : entity1.getBookGenre());
                entity1.setBookId(data.getBookId());
                entity1.setBookTittle(data.getBookTittle()!=null ? data.getBookTittle() : entity1.getBookTittle());
                entity1.setCreatedBy(entity1.getCreatedBy());
                entity1.setPrice(entity1.getPrice());
                entity1.setCreatedDate(entity1.getCreatedDate());
                entity1.setLastModBy(entity1.getLastModBy());
                entity1.setLastModDate(dtf.convertDate(new Date()));
                dao.update(entity1);
                LOG.debug("Successful update of books!");
                retval = new DefaultResp(ServiceStatus.SUCCESS,"Successful update of books!");
            }else{
                LOG.debug("Failed some fields are empty!");
                retval = new DefaultResp(ServiceStatus.FAILED," Failed some fields are empty!");
            }
        }catch(Throwable t){
            LOG.debug("Error in update data! "+t.getLocalizedMessage());
            retval = new DefaultResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
        }finally{
            dao.close();
        }
        return retval;
    }
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public DefaultResp<DeleteData> deleteBook(@PathParam("id") String id) {
//        LOG.debug("Executing deleteBook ws....");
//        DefaultResp retval = null;
//        
//        if(id != null && id.trim().isEmpty() == false
//                && id.matches("^\\d+$")) {
//            DeleteData data = new DeleteData();
//            data.setId(new BigInteger(id));
//            data.setBook("Received the id '" + id + "' for deletion.");
//            
//            retval = new DefaultResp(data, ServiceStatus.SUCCESS,"");
////            retval.setMessage("book for DELETE Operation.");
//        } else {
//            retval = new DefaultResp(ServiceStatus.ERROR, "Invalid Data! Missing id value.");
//        }
//        
//        return retval;
//    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DeleteBook")
    public DefaultResp<BookData> deleteBook(BookData data){
        DefaultResp retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        LOG.debug("user input: "+gson.toJson(data));
        try{
            entity = dao.findById(data.getBookId());
            if(entity!=null){
                dao.hardDelete(entity);
                LOG.debug("Successful deleting of books!");
                retval = new DefaultResp(ServiceStatus.SUCCESS,"Successful deleting of books!");
            }else{
                LOG.debug("Failed book no id found!");
                retval = new DefaultResp(ServiceStatus.FAILED," Failed book no id found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in deleting data! "+t.getLocalizedMessage());
            retval = new DefaultResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
        }finally{
            dao.close();
        }
        return retval;
    }
    
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("ShowBooksByData")
//    public DefaultListResp<BookData> showBooksByDate(BookData data){
//        DefaultListResp retval = null;
//        LOG.debug("User input: "+gson.toJson(data));
//        try{
//            entList = dao.getAllBooksbyDate(data.getCreatedDate());
//            if(entList.size()>0){
//                for(BookStoreEntity ent : entList){
//                    String payload = gson.toJson(ent);
//                    allData = gson.fromJson(payload,BookData.class);
//                    listData.add(allData);
//                }
//                LOG.debug("Successful request! "+gson.toJson(listData));
//                retval = new DefaultListResp(listData,ServiceStatus.FAILED,"finding in books data! ");
//            }else{
//                LOG.debug("Failed finding in books data! ");
//                retval = new DefaultListResp(ServiceStatus.FAILED,"finding in books data! ");
//            }
//        }catch(Throwable t){
//            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
//                retval = new DefaultListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
//        }finally{
//            dao.close();
//        }
//        return retval;
//    }
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("ShowBooksByPrice")
//    public DefaultListResp<BookData> showBooksByPrice(BookData data){
//        DefaultListResp retval = null;
//        LOG.debug("User input: "+gson.toJson(data));
//        try{
//            entList = dao.getAllBooksbyPrice(data.getPrice());
//            if(entList.size()>0){
//                for(BookStoreEntity ent : entList){
//                    String payload = gson.toJson(ent);
//                    allData = gson.fromJson(payload,BookData.class);
//                    listData.add(allData);
//                }
//                LOG.debug("Successful request! "+gson.toJson(listData));
//                retval = new DefaultListResp(listData,ServiceStatus.FAILED,"finding in books data! ");
//            }else{
//                LOG.debug("Failed finding in books data! ");
//                retval = new DefaultListResp(ServiceStatus.FAILED,"finding in books data! ");
//            }
//        }catch(Throwable t){
//            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
//                retval = new DefaultListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
//        }finally{
//            dao.close();
//        }
//        return retval;
//    }
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("ShowBooksByTittle")
//    public DefaultListResp<BookData> showBooksByTittle(BookData data){
//        DefaultListResp retval = null;
//        LOG.debug("User input: "+gson.toJson(data));
//        try{
//            entList = dao.getAllBooksbyTittle(data.getBookTittle());
//            if(entList.size()>0){
//                for(BookStoreEntity ent : entList){
//                    String payload = gson.toJson(ent);
//                    allData = gson.fromJson(payload,BookData.class);
//                    listData.add(allData);
//                }
//                LOG.debug("Successful request! "+gson.toJson(listData));
//                retval = new DefaultListResp(listData,ServiceStatus.FAILED,"finding in books data! ");
//            }else{
//                LOG.debug("Failed finding in books data! ");
//                retval = new DefaultListResp(ServiceStatus.FAILED,"finding in books data! ");
//            }
//        }catch(Throwable t){
//            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
//                retval = new DefaultListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
//        }finally{
//            dao.close();
//        }
//        return retval;
//    }
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("ShowBooksByAuthor")
//    public DefaultListResp<BookData> showBooksByAuthor(BookData data){
//        DefaultListResp retval = null;
//        LOG.debug("User input: "+gson.toJson(data));
//        try{
//            entList = dao.getAllBooksbyAuthor(data.getBookAuthor());
//            if(entList.size()>0){
//                for(BookStoreEntity ent : entList){
//                    String payload = gson.toJson(ent);
//                    allData = gson.fromJson(payload,BookData.class);
//                    listData.add(allData);
//                }
//                LOG.debug("Successful request! "+gson.toJson(listData));
//                retval = new DefaultListResp(listData,ServiceStatus.FAILED,"finding in books data! ");
//            }else{
//                LOG.debug("Failed finding in books data! ");
//                retval = new DefaultListResp(ServiceStatus.FAILED,"finding in books data! ");
//            }
//        }catch(Throwable t){
//            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
//                retval = new DefaultListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
//        }finally{
//            dao.close();
//        }
//        return retval;
//    }
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("ShowBooksByGenre")
//    public DefaultListResp<BookData> showBooksByGenre(BookData data){
//        DefaultListResp retval = null;
//        LOG.debug("User input: "+gson.toJson(data));
//        try{
//            entList = dao.getAllBooksbyGenre(data.getBookGenre());
//            if(entList.size()>0){
//                for(BookStoreEntity ent : entList){
//                    String payload = gson.toJson(ent);
//                    allData = gson.fromJson(payload,BookData.class);
//                    listData.add(allData);
//                }
//                LOG.debug("Successful request! "+gson.toJson(listData));
//                retval = new DefaultListResp(listData,ServiceStatus.FAILED,"finding in books data! ");
//            }else{
//                LOG.debug("Failed finding in books data! ");
//                retval = new DefaultListResp(ServiceStatus.FAILED,"finding in books data! ");
//            }
//        }catch(Throwable t){
//            LOG.debug("Error in show all books data! "+t.getLocalizedMessage());
//                retval = new DefaultListResp(ServiceStatus.ERROR," "+t.getLocalizedMessage());
//        }finally{
//            dao.close();
//        }
//        return retval;
//    }
}
