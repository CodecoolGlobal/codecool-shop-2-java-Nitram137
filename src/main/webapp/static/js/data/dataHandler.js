export let dataHandler = {
    getProductsByCategory: async function (categoryId) {
        return await apiGet(`/api/filter?category=${categoryId}`);
    },
    getProductsBySupplier: async function (supplierId) {
        return await apiGet(`/api/filter?supplier=${supplierId}`);
    },
    getCart: async function (cart) {
        return await apiPost('/api/cart', cart);
    }
}

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    if (!response.ok) {
        throw Error(`${response.status} ${response.statusText}`);
    }
    return response.json();
}

async function apiPost(url, payload) {
        let response = await fetch(url, {
            method: "POST",
            headers: {"content-type":"application/json"},
            body:JSON.stringify(payload)

        });
        if(!response.ok) {
            throw Error(`${response.status} ${response.statusText}`);
        }
        return response.json();
}