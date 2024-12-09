{
  description = "Nix flake for software development";

  inputs = {
    nixpkgs.url = "nixpkgs/nixpkgs-unstable";
  };

  outputs = {nixpkgs, ...}: let
    system = "x86_64-linux";
  in {
    devShells."${system}".default = let
      pkgs = import nixpkgs {
        inherit system;
        config.allowUnfree = true;
      };
    in
      pkgs.mkShell {
        packages = with pkgs; [
          # jetbrains.idea-ultimate
          jdt-language-server

          jdk8
        ];

        shellHook = ''
          echo "Java Version:"
          java -version
        '';
      };
  };
}
