import { TabulatorFull as Tabulator } from "tabulator-tables";

let table;

document.addEventListener("DOMContentLoaded", function () {
  //テーブルの初期化
  //読み込み完了時にデータロードを行う
  table = new Tabulator("#user-table", {
    columns: [
      { title: "ID", field: "id" },
      { title: "Name", field: "name" },
      { title: "Mail", field: "mail" },
    ],
    data: [],
  });
  table.on("tableBuilt", () => {
    fetchUsers();
  });

  document.getElementById("user-submit").addEventListener("click", () => {
    addUser();
  });
});

const fetchUsers = async () => {
  console.log("fetchUsers");
  const res = await fetch("/admin/master/user/search", {
    method: "GET",
    credentials: "include",
  });
  const users = await res.json();
  table.setData(users);
};

const addUser = async () => {
  const name = document.getElementById("name").value;
  const mail = document.getElementById("mail").value;
  const password = document.getElementById("password").value;

  const token = document
    .querySelector("meta[name='_csrf']")
    .getAttribute("content");
  const header = document
    .querySelector("meta[name='_csrf_header']")
    .getAttribute("content");

  const res = fetch("/admin/master/user/add", {
    method: "POST",
    credentials: "include",
    headers: {
      "Content-Type": "application/json",
      [header]: token,
    },
    body: JSON.stringify({ name, mail, password }),
  })
    .catch((error) => {
      console.log(error);
      alert("エラーが発生しました");
      return;
    })
    .then((res) => {
      if (!res.ok) {
        alert("入力エラーが発生しました");
        return;
      }
      alert("追加しました");
      fetchUsers();
    });
};
