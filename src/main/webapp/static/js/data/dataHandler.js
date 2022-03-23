export let dataHandler = {
    getProductsByCategory: async function (categoryId) {
        return await apiGet(`/api/filter?category=${categoryId}`);
    },
    getProductsBySupplier: async function (supplierId) {
        return await apiGet(`/api/filter?supplier=${supplierId}`);
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