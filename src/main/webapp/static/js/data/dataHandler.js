export let dataHandler = {
    getProductsByCategory: async function (categoryId) {
        return await apiGet(`/api/filter?category=${categoryId}`);
    }
}

async function apiGet(url) {
    try {
        let response = await fetch(url, {
            method: "GET",
        });
        if (!response.ok) {
            throw Error(`${response.status} ${response.statusText}`);
        }
        return response.json();
    } catch (error) {
        console.log('Looks like there was a problem', error);
    }
}