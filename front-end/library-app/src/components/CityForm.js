import React from 'react';
import { Form, Button } from 'react-bootstrap';

const CityForm = () => {
    const reqBase = 'http://localhost:8080/api/cities';
    const saveCity = (e) => {
        e.preventDefault();
        let name = document.getElementById("nameId").value;
        if (name === "") {
            name = null;
        }

        let obj = { name };


        document.getElementById("nameId").value = "";

        fetch(reqBase,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(obj)
            })
            .then(() => {
                alert("City successfully saved. ")
            })
            .catch(e => {
                console.log(e);
                return e;
            });

    }
    return (
        <div id="formCmp" style={{ margin: 'auto', width: '500px', marginTop: '20px' }}>
            <Form>
                <h3 style={{ marginBottom: '30px', color: '#696766' }}>Insert City</h3>

                <Form.Group>
                    <Form.Label>Name:</Form.Label>
                    <Form.Control id="nameId" />
                </Form.Group>

                <Button variant="primary" type="submit" onClick={saveCity}>
                    Add City
                </Button>
            </Form>
        </div>

    );
}

export default CityForm;