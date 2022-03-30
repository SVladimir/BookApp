import React from 'react'
import { useEffect, useState } from 'react';
import { Form } from 'react-bootstrap';


const CitiesList = ({ getCity }) => {
    const searchName = "http://localhost:8080/api/cities";
    const [cities, setCities] = useState([]);

    const handleSelect = (e) => {
        let p = e.target.value;
        let obj = {  p };
        getCity(obj);
    }
    useEffect(() => {
        const loadAuthors = () => {
            fetch(searchName)
                .then(res => res.json())
                .then(res => {
                    setCities(res);
                })
                .catch(e => {
                    console.log(e);
                    return e;
                });
        }
        loadAuthors();
    }, [])
    return (
        <Form.Group controlId="exampleForm.SelectCustom">
            <Form.Control as="select" placeholder="something" onChange={handleSelect}>
                <option value="" default >City</option>
                {
                    cities.map((a) => {
                        let name = "";

                        if (a.name !== undefined) {
                            name = a.name;
                        }

                        let cityInf = "ID:" +  name;
                        return (<option key={a.name} value={a.name}>{cityInf}</option>)
                    })
                }
            </Form.Control>
        </Form.Group>

    );
}
export default CitiesList;