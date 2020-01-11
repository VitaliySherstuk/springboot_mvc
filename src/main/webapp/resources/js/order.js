function orders() => {
const data = [];
const nameTd = [];
const Table = $('#cars');
const numberTr = Table.find('tr').length;
const numberTd = Table.find('tr:first > td').length;

for (let i = 1; i <= numberTd; i++) {
    nameTd.push(Table.find(`tr:first-child > td:nth-child(${i})`).text());
}

for (let i = 2; i <= numberTr; i++) {
    const objectTd = {};

    for (let k = 0; k < nameTd.length; k++) {
        objectTd[nameTd[k]] = Table.find(`tr:nth-child(${i})>td:nth-child(${k + 1})`).text();
    }

    data.push(objectTd);
}
console.log(data);
};