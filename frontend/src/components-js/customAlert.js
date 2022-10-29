class CustomAlert extends HTMLElement {
  constructor() {
    super();
    this.message = this.getAttribute("message");
    const messageClasses = {
      error: "alert-danger",
      info: "alert-info",
    };
    this.messageType = messageClasses[this.getAttribute("messageType")];

    const template = document.getElementById("alert-template");
    const dom = template.content.cloneNode(true);
    dom.querySelector(".alert").classList.add(this.messageType);
    dom.querySelector(".message").innerText = this.message;
    this.appendChild(dom);
  }
  connectedCallback() {}
}

customElements.define("custom-alert", CustomAlert);
