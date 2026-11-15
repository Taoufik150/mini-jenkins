const test = require("node:test");
const assert = require("node:assert");
const { greet } = require("./src/utils.js");

test("greet retourne un message", () => {
  assert.strictEqual(greet("Taoufik"), "Bonjour Taoufik !");
});
